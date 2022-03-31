(defun evolveCell (cell aliveNeighbors)
    (cond
      ((eq cell 0)
        (cond
          ((eq aliveNeighbors 3) 1)
          (t 0)
        )
      )
      ((eq cell 1)
        (cond
          ((eq aliveNeighbors 2) 1)
          ((eq aliveNeighbors 3) 1)
          (t 0)
        )
      )
    )
)


(defun evolveGrid (grid)
    (
        let ((y -1))
        (mapcar #'(lambda (row)
            (incf y)
            (
                let ((x -1))
                (mapcar #'(lambda (cell)
                    (incf x)
                    (evolveCell
                      (getCell x y grid)
                      (getNeighbours x y grid)
                    )
                ) row)
            )
        ) grid)
    )
)


(defun getCell (x y grid)
    (
        cond
          ((< x 0) 0)
          ((< y 0) 0)
          (t  (or (nth x (nth y grid))0))
    )
)

(defun getNeighbours (x y grid)
    (
        reduce '+
            (
                list
                    (getCell (- x 1) (- y 1) grid)
                    (getCell x (- y 1) grid)
                    (getCell (+ x 1) (- y 1) grid)

                    (getCell (- x 1) y grid)
                    (getCell (+ x 1) y grid)

                    (getCell (- x 1) (+ y 1) grid)
                    (getCell x (+ y 1) grid)
                    (getCell (+ x 1) (+ y 1) grid)

            )
    )
)

(let (
   (grid '(
     (0 0 0 0 0 0)
     (0 0 0 0 0 0)
     (0 0 1 1 1 0)
     (0 1 1 1 0 0)
     (0 0 0 0 0 0)
     (0 0 0 0 0 0)
   ))
 )

 (loop for riga in (evolveGrid grid) do (print riga))
))
