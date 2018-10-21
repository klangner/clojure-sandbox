(ns clojure-sandbox.core (:gen-class))

;; REPL helpers
;; Reload file
;; (use 'clojure-sandbox.core :reload)

(defn say-hello
  "Say hello to the given name"
  [name]
  (str "Welcome " name " to the world!"))

(defn -main
  "Welcome aliens on our world."
  [& args]
  (map say-hello args))


