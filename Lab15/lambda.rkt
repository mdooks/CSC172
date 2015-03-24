(define x 3)
(define y 5)
(display x) (newline)
(display y) (newline)
(+ x y)

(define foo (list + x y))
(define bar (list + 'x 'y))
(display foo) (newline)
(display bar) (newline)

(set! x 123)
(set! y 456)

(eval foo)
(eval bar)

(define (sum-ints a b)
  (if (> a b)
      0
      (+ a (sum-ints (+ a 1) b))))
(sum-ints 1 3)
(sum-ints 1 10)

(define (square x) (* x x))
(define (cube x) (* x x x))

(square 3)
(cube 3)

(define (sum-sqrs a b)
  (if (> a b)
      0
      (+ (square a) (sum-sqrs (+ a 1) b))))

(sum-sqrs 1 5)

(define (sum-cubes a b)
  (if (> a b)
      0
      (+ (cube a) (sum-cubes (+ a 1) b))))

(sum-cubes 1 5)

(define (summer term a b)
  (if (> a b)
      0
      (+ (term a) (summer term (+ a 1) b))))

(define (sum-cubes2 a b) (summer cube a b))
(define (sum-sqrs2 a b) (summer square a b))

(sum-cubes2 1 5)
(sum-sqrs2 1 5)

(define (id x) x)
(define (tri-sum2 a b)(summer id a b))
(tri-sum2 1 5)

(define (plus-three x) (+ x 3))
(plus-three 9)
(define plus-four (lambda(x) (+ x 4)))
(plus-four 4)

(lambda(x) (+ x 4))
((lambda(x) (+ x 5)) 21)
((lambda (x y) (* x y)) 7 13) 
(define (tri-sum3 a b) (summer (lambda(x) x) a b))
(define (sum-sqrs3 a b) (summer (lambda(x) (* x x)) a b))
(define (sum-cubes3 a b) (summer (lambda(x) (* x x x)) a b))
(tri-sum3 1 5)
(sum-sqrs3 1 5)
(sum-cubes3 1 5)

(define (geo-sum a b) (summer (lambda(x) (/ 1 x)) a b))
(geo-sum 1 5)

(define (f x y)
 ((lambda (a b)
 (+ (* x (* a a))
 (* y b)
 (* a b))
 ) 
 (+ 1 (* x y)) 
 (- 1 y) 
))
(f 1 1)
(f 8 7)

(define (f2 x y)
 (let ((a (+ 1 (* x y )))
 (b (- 1 y)))
 (+ (* x (* a a))
 (* y b)
 (* a b )
 )
 )
) 
(f2 1 1)
(f2 8 7)