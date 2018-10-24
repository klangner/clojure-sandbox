(ns clojure-sandbox.fwpd)

(def filename "suspects.csv")

(def vamp-keys [:name :glitter-index])

(defn str->int
  [str]
  (Integer. (clojure.string/trim str)))

(def conversions {:name identity
                  :glitter-index str->int})

(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))

(defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
       (clojure.string/split string #"\n")))

(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index: 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [key value]]
                   (assoc row-map key (convert key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))

(defn glitter-filter
  [minimum-glitter records]
  (filter #(>= (:glitter-index %) minimum-glitter) records))

;; Ex 1. Get names only
(defn names
  [records]
  (map :name records))

;; Ex 2. Append suspect to the database
(defn append-suspect
  [records new-suspect]
  (conj records new-suspect))

;; Ex 3. Validate record
(defn validate
  [record keys]
  (every? identity
    (map (fn [key] (not= nil (key record))) keys)))

;; Ex 4. Write to CSV
(defn record-to-string
  [record]
  (clojure.string/join "," (map #(% record) vamp-keys)))

(defn to-csv
  [records]
  (clojure.string/join "\n"
                       (map record-to-string records)))