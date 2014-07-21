; Exercise 1.43; Composing functions an arbitrary number of times

(defn repeated [func numberOfRepeats]
  (repeated-iter func numberOfRepeats func))

(defn repeated-iter [func numberOfRepeats partialFunc]
  (if (= 1 numberOfRepeats)
    partialFunc
    (repeated-iter func
                   (- numberOfRepeats 1)
                   (fn [x] (func (partialFunc x))))))

(defn square [x] (* x x))

((repeated square 2) 5)
