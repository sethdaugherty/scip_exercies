; These two functions are operations in this thought experiment and shouldn't be included in the time analysis.
(defn double_ [num] (+ num num))
(defn halve_ [num] (/ num 2))

(defn fast-multiply [num1 num2]
  (cond
    (= num2 0) 0
    (even? num2) (double_ (fast-multiply num1 (halve_ num2)))
    :else
      (+ num1 (fast-multiply num1 (- num2 1)))
    )
)

(println "2 * 3: ")
(println (fast-multiply 2 3))
(println "4 * 5: ")
(println (fast-multiply 4 5))
(println "6 * 3: ")
(println (fast-multiply 6 3))
