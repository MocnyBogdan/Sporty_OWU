(ns learning-progr.core-test
      (:require [clojure.test :refer :all ]
                [learning-progr.parsing :refer :all]
                [clojure.string :as str])
  )
(def dummyPDF "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf")

(deftest text-of-pdf-test
  (testing "scrapes dummy pdf"
    (is (= "Dummy PDF file\r\n" (text-of-pdf "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"))))
  )
(deftest vector-of-sports-test
  (testing "creates a vector..."
    (is (vector? (vector-of-sports dummyPDF "dum" "p"))
      )
    )
  (testing "...of strings"
    (is (string? (get (vector-of-sports dummyPDF "dum" "p") 1)))
  ))

(deftest find-sports-test
  (testing "returns a number"
    (is (number? (find-sports (text-of-pdf dummyPDF) "pdf")))
    )
  )

(run-tests)