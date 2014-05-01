; These two functions are operations in this thought experiment and shouldn't be included in the time analysis.
(defn double_ [num] (+ num num))
(defn halve_ [num] (/ num 2))

; Iterative implementation of the multiplication algorithm

(defn fast-multiply-iter [num1 num2 a]
  (cond
    (= num2 0) a
    (even? num2) (fast-multiply-iter (double_ num1) (halve_ num2) a)
    :else
      (fast-multiply-iter num1 (- num2 1) (+ num1 a))
    )
)

(defn fast-multiply [num1 num2]
  (fast-multiply-iter num1 num2 0))

(println "2 * 3: ")
(println (fast-multiply 2 3))
(println "4 * 5: ")
(println (fast-multiply 4 5))
(println "6 * 3: ")
(println (fast-multiply 6 3))
