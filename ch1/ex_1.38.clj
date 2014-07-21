; Exercise 1.37 approximation of 'e - 2' using a continued fraction

; Iterative solution

(defn cont-frac [numeratorFunc denominatorFunc maxIteration]
  (cont-frac-iter numeratorFunc denominatorFunc 1 maxIteration 0))

(defn cont-frac-iter [numeratorFunc denominatorFunc iteration maxIteration partialResult]
  (if (= iteration maxIteration)
    partialResult
    (/ (numeratorFunc iteration)
       (+ (denominatorFunc iteration)
          (cont-frac-iter numeratorFunc
                          denominatorFunc
                          (+ iteration 1)
                          maxIteration
                          (/ (numeratorFunc iteration)
                             (+ (denominatorFunc iteration)
                                partialResult)
                          )
          )
       )
    )
 )
)


(defn denomFunc [x]
  (if (= 0 (mod (+ 1 x) 3))
    (/ (* 2
          (+ 1 x))
       3)
    1))

(cont-frac (fn [i] 1.0)
           denomFunc
           7)


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
                     denomFunc
                    12)
