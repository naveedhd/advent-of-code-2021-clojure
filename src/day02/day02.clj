(ns day02)

(require '[clojure.string :as str])


(defn mover [[x y] [direction spaces]]
  (case direction
    :forward [(+ x spaces) y]
    :down [x (+ y spaces)]
    :up [x (- y spaces)]))

(defn mover2 [[x y angle] [direction spaces]]
  (case direction
    :forward [(+ x spaces) (+ y (* angle spaces)) angle]
    :down [x y (+ angle spaces)]
    :up [x y (- angle spaces)]))

(defn solve [mover-func init-val]
  (->> (slurp "src/day02/input")
       (str/split-lines)
       (map #(str/split % #" "))
       (map (fn [[a b]] [(keyword a) (Integer. b)]))
       (reduce mover-func init-val)
       (take 2)
       (apply *)))

(solve mover [0 0])
(solve mover2 [0 0 0])