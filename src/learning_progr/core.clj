(ns learning-progr.core
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [learning-progr.web :as web]
            [ring.adapter.jetty :as jetty]
            [learning-progr.parsing :refer :all]
            ))

;(defn list-extreme-sports
;  [url]
; (vector-of-sports (text-of-pdf (find-sports AvivaOWU AvivaSubtitle)) AvivaBreaker) )

(defn -main
  [& args]
;  (vector-of-sports AvivaOWU AvivaSubtitle AvivaBreaker)
  (jetty/run-jetty web/web {:port 3000})
  )

