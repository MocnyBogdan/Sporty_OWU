(ns learning-progr.web
  (:require [learning-progr.parsing :refer :all]
            [hiccup.page :refer [html5]]
            )
  )


;(defn web [& params]
;  {:status  200
;   :body (vector-of-sports AvivaOWU AvivaSubtitle AvivaBreaker)   }  )

(defn web [& params]
  {:status 200
   :body
   (html5 [:head
           [:title "Sports"]]
          [:body
           [:h1 (concat "List of " AvivaSubtitle)]
           [:ul (map #(vector :li %) (vector-of-sports AvivaOWU AvivaSubtitle AvivaBreaker))]
           ]

          )}
   )
