(ns hello-clj.demo_json
  #_(:require [clojure.data.json :as json]))

(require '[clojure.data.json :as json])

(println (json/read-str "{\"a\":1,\"b\":2}"))