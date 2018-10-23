;;
;; Clojure for the Brave and true: Chapter 4
;;
(ns clojure-sandbox.brave4)

;; Functions

;; map works also like zip
(map + [1 2 3] [4 5 6])

;; Seq can contain functions
(def sum #(reduce + %))

(def avg #(/ (sum %) (count %)))

(defn stats
  [numbers]
  (map #(% numbers) [sum count avg]))


;; reduce

;; Similar to map but without returning list as map does
(reduce (fn [new-map [key val]]
          (assoc new-map key (inc val)))
        {}
        {:max 30 :min 10})
; => {:max 31, :min 11}

;; reduce as a filter
(reduce (fn [new-map [key value]]
          (if (> value 4)
            (assoc new-map key value)
            new-map))
        {}
        {:human 4.1 :critter 3.9})


;; Finding vampire (thread and time). Lazy evaluation
(def vampire-database
  {0 {:makes-blood-puns? false :has-pulse? true :name "McFishwich"}
   1 {:makes-blood-puns? false :has-pulse? true :name "McMason"}
   2 {:makes-blood-puns? true :has-pulse? false :name "Damon"}
   3 {:makes-blood-puns? true :has-pulse? false :name "Mickey Mouse"}})

(defn vampire-related-details
  [social-security-number]
  (Thread/sleep 1000)
  (get vampire-database social-security-number))

(defn vampire?
  [record]
  (and (:makes-blood-puns? record)
       (not (:has-pulse? record))
       record))

(defn identify-vampire
  [social-security-numbers]
  (first (filter vampire?
                 (map vampire-related-details social-security-numbers))))

;; Lazy sequences
(defn even-numbers
  ([] (even-numbers 0))
  ([n] (cons n (lazy-seq (even-numbers (+ n 2 ))))))

;; apply
(apply max [1 2 3])