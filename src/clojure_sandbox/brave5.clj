;;
;; Clojure for the Brave and true: Chapter 5
;;
(ns clojure-sandbox.brave5)

;; Function composition

(def player
  {:name "Taurys"
   :attributes {:intelligence 10
                :streangth 4
                :dexterity 5}})

(def player-int (comp :intelligence :attributes))

(defn spell-slots
  [player]
  ((comp int inc #(/ % 2) player-int) player))
