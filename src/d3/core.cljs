(ns ^:figwheel-hooks d3.core
  (:require
   [goog.dom :as gdom]))

(println "This text is printed from src/d3/core.cljs. Go ahead and edit it and see reloading in action.")

(defn multiply [a b] (* a b))


;; define your app data so that it doesn't get over-written on reload
; (defonce app-state (atom {:text "Hello world!"}))

; (defn get-app-element []
;   (gdom/getElement "app"))

(def width 800)
(def height 600)

(defn append-svg []
  (-> js/d3
      (.select "#canvas")
      (.append "svg")
      (.attr "height" height)
      (.attr "width" width)
        (.append "rect")
        (.attr "x" 20)
        (.attr "y" 20)
        (.attr "height" 50)
        (.attr "width" 50)))

;; specify reload hook with ^;after-load metadata
(defn ^:after-load on-reload []
  (-> js/d3
      (.select "#canvas svg")
      (.remove))
)

;; main
(append-svg)
