(ns zookeeper-znode-counter.core
  (:require [zookeeper :as zk]
            [clojure.string :as string]
            [clojure.tools.cli :refer [parse-opts]])
  (:gen-class))

(defn create-zk-connection [host port]
  (def zkclient (zk/connect (string/join ":" [host port]))))


(defn count-children [path]
  (let [children (zk/children zkclient path)]
      (if (zero? (count children))
        0
        (let [total (+ (count children)
        (apply + (map #(count-children (str path (if (= path "/") "" "/") %)) children)))]
        total))))

(def cli-options
            [[ "-h" "--host host" "ZKHost"
              :default "localhost"]

             ["-p" "--port port" "ZKPort"
              :default 2181]

             ["-z" "--path path" "ZNodePath"
               :default "/zookeeper"]])


  (defn -main
    [& args]
    (let  [ {:keys [options]} (parse-opts args cli-options)
          zkhost (:host options)
          zkport (:port options)
          znodepath (:path options)]
          (create-zk-connection zkhost zkport)
          (println (str "Total Count for " znodepath " is " (count-children znodepath)))
           (doseq [ child (zk/children zkclient znodepath)]
            (println (str "Child Count for " znodepath"/"child "is : " (count-children (str znodepath"/"child))))
           )
          (zk/close zkclient)))
