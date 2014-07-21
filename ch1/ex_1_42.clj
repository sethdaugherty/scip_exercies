; Exercise 1.42. Function composition

(defn compose [func1 func2]
  (fn [x]
    (func1 (func2 x))))

(defn square [x] (* x x))
(defn increment [x] (+ x 1))

((compose square increment) 6)
