;;
;; Clojure for the Brave and true: Chapter 3
;;

(ns clojure-sandbox.brave3)

;; Destructuring

;; Return the first element of a collection
(defn my-first
  [[first-thing]]
  first-thing)

;; Shortcut
(defn announce-treasure-location
  [{:keys [lat long]}]
  (println (str "Lat: " lat))
  (println (str "Long: " long)))

;; Function body

(defn illustrative-function
  []
  (+ 1 2 3)
  30
  "joe")

;; Anonymous functions
(map (fn [name] (str "Hi " name)) ["Ala" "Ola"])
;; or
(map #(str "Hi " %) ["Ala" "Ola"])
