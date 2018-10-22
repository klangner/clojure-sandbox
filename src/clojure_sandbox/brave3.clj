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

;; Hobbit

(def asym-hobbit-parts [{:name "head" :size 3}
                        {:name "left-eye" :size 1}
                        {:name "left-ear" :size 1}
                        {:name "mouth" :size 1}])

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(defn symetrize-body-parts
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set [part (matching-part part)])))
          []
          asym-body-parts))