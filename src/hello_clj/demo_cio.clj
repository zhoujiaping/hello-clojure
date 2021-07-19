(ns hello-clj.demo_cio
  #_(:import (java.io BufferedReader)))

(import java.io.BufferedReader)
(require '[clojure.java.io :as cio])

(def demoFile "/Users/tuya/properties/application-local.properties")

(let [text (slurp demoFile :encoding "UTF-8")]
  (println text))

(defn read-by-line
  "line-fn：处理一行数据的函数"
  [file-path line-fn]
  (with-open [^BufferedReader rdr (cio/reader file-path :encoding "UTF-8")]
    (doseq [a (line-seq rdr)]
      (line-fn a))))

(read-by-line ::demoFile
              (partial println "a line ===== "))

;; 逐行写大量数据到文件时，用spit会降低效率，因为它每写一次都会执行打开、关闭文件。
;; 此时可以用java.io.writer.
(with-open [w (cio/writer ::demoFile)]
  (doseq [l ["第一行" "第二行" "第三行"]]
    (.write w l)
    ;; 新起一行
    (.newLine w)))