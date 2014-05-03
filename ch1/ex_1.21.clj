; Simple, inefficient algorithm to find the smallest divisor of a set of numbers

(defn find-divisor [n test-divisor]
    (cond (> (* test-divisor test-divisor) n) n
      (= 0 (rem n test-divisor)) test-divisor
      :else
        (find-divisor n (+ test-divisor 1)))
  )

(defn smallest-divisor [n]
  (find-divisor n 2))

(println (smallest-divisor 199))
(println (smallest-divisor 1999))
(println (smallest-divisor 19999))
