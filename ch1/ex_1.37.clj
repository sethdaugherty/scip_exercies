; Exercise 1.37 approximation of 1/(golden ratio) using a continued fraction

; Iterative solution

(defn cont-frac [numeratorFunc denominatorFunc maxIteration]
  (cont-frac-iter numeratorFunc denominatorFunc maxIteration 0))

(defn cont-frac-iter [numeratorFunc denominatorFunc iteration partialResult]
  (if (= iteration 0)
    partialResult
    (/ (numeratorFunc iteration)
       (+ (denominatorFunc iteration)
          (cont-frac-iter numeratorFunc
                          denominatorFunc
                          (- iteration 1)
                          (/ (numeratorFunc iteration)
                             (+ (denominatorFunc iteration)
                                partialResult)
                          )
          )
       )
    )
 )
)

(cont-frac (fn [i] 1.0)
           (fn [i] 1.0)
           6)


; Recursive solution

(defn cont-frac-recursive [numeratorFunc denominatorFunc maxIteration]
  (frac-recur numeratorFunc denominatorFunc 1 maxIteration))

(defn frac-recur [numeratorFunc denominatorFunc currentIteration maxIteration]
  (if (= currentIteration maxIteration)
    (/ (numeratorFunc maxIteration)
       (denominatorFunc maxIteration))
    (/ (numeratorFunc currentIteration)
       (+ (denominatorFunc currentIteration)
          (frac-recur numeratorFunc denominatorFunc (+ currentIteration 1) maxIteration)
       )
    )
  )
)

(cont-frac-recursive (fn [i] 1.0)
                     (fn [i] 1.0)
                    12)
