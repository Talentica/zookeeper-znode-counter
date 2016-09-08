# zookeeper-znode-counter

Tool to count the total children recursively for a given Znode

## Installation

```
lein uberjar
```

## Usage

```
java -jar zookeeper-znode-counter-0.1.0-SNAPSHOT-standalone.jar -h "zookeeper.yourserver.net" -p 2181 -z "/mesos"
```



## Options

```
-h/--host : Hostname of the zookeeper server
-p/--port : Port of the zookeeper server
-z/--path : Znode Path
```

## Bugs

If there are high number of children for a particular Znode, it might result in following error

```
Exception in thread "main" org.apache.zookeeper.KeeperException$ConnectionLossException: KeeperErrorCode = ConnectionLoss for /consumers
        at org.apache.zookeeper.KeeperException.create(KeeperException.java:99)
        at org.apache.zookeeper.KeeperException.create(KeeperException.java:51)
        at org.apache.zookeeper.ZooKeeper.getChildren(ZooKeeper.java:1472)
```

### Solution

Copy the `jar` file to the zookeeper server and execute the same on zookeeper server.


## TODO


## License

Copyright © 2016 Talentica Software India Pvt. Ltd.

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
