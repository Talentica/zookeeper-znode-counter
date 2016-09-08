(defproject zookeeper-znode-counter (str "1.0." (System/getenv "CIRCLE_BUILD_NUM")"-SNAPSHOT")
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [zookeeper-clj "0.9.4"]
                 [org.clojure/tools.cli "0.3.5"]]
  :main ^:skip-aot zookeeper-znode-counter.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
