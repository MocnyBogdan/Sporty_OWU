(ns learning-progr.parsing
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            )
  (:import [org.apache.pdfbox.pdmodel PDDocument]
           [org.apache.pdfbox.text PDFTextStripper]
           (java.net URL))
  )

(def AvivaOWU "https://www.aviva.pl/content/dam/aviva-public/pl/ubezpieczenia/ubezpieczenia_majatku/ubezpieczenieturystyczne/dokumenty/OWU_Twoja_Podroz_1_2018.pdf")

(def AvivaSubtitle "sporty wysokiego ryzyka")
(def AvivaBreaker ", ")


(defn text-of-pdf
  [url]
  (with-open [pd (PDDocument/load (io/input-stream (URL. url)))]
    (let [stripper (PDFTextStripper. )]
      (.getText stripper pd ))))

(defn find-sports
  [owu sports-subtitle]
  (+ (str/index-of (str/lower-case owu) sports-subtitle) (count sports-subtitle))
  )

(defn cutsports
  [owu sports-subtitle & {:keys [size]
                          :or {size 1478}}]
  (let [sports-start-index (find-sports owu sports-subtitle)
        sports-end-index   (+ sports-start-index size)]
    (subs owu sports-start-index sports-end-index)
    ))

(defn vector-of-sports
  [url subtitle breaker]
  (let [sports (cutsports(text-of-pdf url) subtitle)]
    (map str/trim(str/split (str/trim-newline sports) (re-pattern breaker)))))


;(defn list-extreme-sports
;  [url]
; (vector-of-sports (text-of-pdf (find-sports AvivaOWU AvivaSubtitle)) AvivaBreaker) )

