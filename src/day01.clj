(ns day01)

(require '[clojure.string :as str])

;; part 1
(->> (slurp "src/input")
     (str/split-lines)
     (map #(Integer/parseInt %))
     (partition 2 1)
     (filter (fn [[a b]] (< a b)))
     (count))

;; part 2
(->> (slurp "src/input")
     (str/split-lines)
     (map #(Integer/parseInt %))
     (partition 3 1)
     (map #(apply + %))
     (partition 2 1)
     (filter (fn [[a b]] (< a b)))
     (count))
