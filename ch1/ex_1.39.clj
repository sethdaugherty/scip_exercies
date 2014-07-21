; Exercise 1.39 approximation of the tangent function using a continued fraction

(defn numeratorFunc [x iteration]
  (if (= 1 x)
    x
    (* x x)))
(defn denominatorFunc [x]
  (- (* x 2) 1))

; Recursive solution

(defn tan-cf [x maxIteration]
  (frac-recur x 1 maxIteration))

(defn frac-recur [x currentIteration maxIteration]
  (if (= currentIteration maxIteration)
    (/ (numeratorFunc x maxIteration)
       (denominatorFunc maxIteration))
    (/ (numeratorFunc x currentIteration)
       (- (denominatorFunc currentIteration)
          (frac-recur x (+ currentIteration 1) maxIteration)
       )
    )
  )
)

(tan-cf 1.0 12)
(Math/tan 1)
