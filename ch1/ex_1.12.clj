; Implementation of recursive procedure to compute rows of Pascal's triangle

; recursive implementation
(defn pascal [row column]
  (cond
    (>= 0 row) (throw (Exception. "Row must be positive"))
    (>= 0 column) (throw (Exception. "Column must be positive"))
    (= row column) 1
    (> column row) (throw (Exception. (str "Invalid column " column)))
    (= row 1) 1
    (= column 1) 1
    :else
      (+ 
        (pascal (- row 1) (- column 1)) 
        (pascal (- row 1) column)))
)

(print "row 1 column 1: ")
(println (pascal 1 1))
(print "row 2 column 1: ")
(println (pascal 2 1))
(print "row 2 column 2: ")
(println (pascal 2 2))
(print "row 3 column 1: ")
(println (pascal 3 1))
(print "row 3 column 2: ")
(println (pascal 3 2))
(print "row 3 column 3: ")
(println (pascal 3 3))
(print "row 4 column 1: ")
(println (pascal 4 1))
(print "row 4 column 2: ")
(println (pascal 4 2))
(print "row 4 column 3: ")
(println (pascal 4 3))
(print "row 4 column 4: ")
(println (pascal 4 4))
