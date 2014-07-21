; Exercise 1.41. Procedure to double other procedures

(defn doubleFunc [func]
  (fn [x]
    (func (func x))))

(defn increment [x] (+ x 1))

; Testing doubleFunc with a simple increment function
((doubleFunc increment) 2)

; doubling doubleFunc
(((doubleFunc (doubleFunc doubleFunc)) increment) 5)
