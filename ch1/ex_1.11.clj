; recursive implementation of f(n) = f(n-1) + 2f(n-2) + 3f(n-3)
(defn f-recursive [x]
      (cond
          (< x 3) x
          :else 
              (+ (f-recursive (- x 1))
                 (* 2
                    (f-recursive (- x 2)))
                 (* 3
                    (f-recursive (- x 3)))
              )
          )
      )

(println "Recursive implementation")
(println (f-recursive 1))
(println (f-recursive 2))
(println (f-recursive 3))
(println (f-recursive 4))
(println (f-recursive 5))
(println (f-recursive 6))


; iterative implementation of f(n) = f(n-1) + 2f(n-2) + 3f(n-3)
(defn f-iter [x x2 x3 count]
      (cond 
           (< count 3) x
           :else 
               (f-iter 
                   (+ x (* 2 x2) (* 3 x3))
                   x
                   x2
                   (- count 1)
               )
      )
)

(defn f-iterative [x]
     (f-iter 2 1 0 x)
)


(println "Iterative implementation")
(println (f-iterative 1))
(println (f-iterative 2))
(println (f-iterative 3))
(println (f-iterative 4))
(println (f-iterative 5))
(println (f-iterative 6))
