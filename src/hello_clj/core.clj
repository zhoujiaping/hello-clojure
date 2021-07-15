(ns hello-clj.core
  (:gen-class))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(foo "bar")

(defn -main [& args]
  (println "hello world"))

(defn hi []
  (println "hi"))

(hi)



