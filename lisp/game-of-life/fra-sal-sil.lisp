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
        let ((y 0))
        (
            mapcar #'
            (
                lambda (row)
                (
                    let ((x 0)
                    (
                        gino
                        (
                           mapcar #'
                           (
                                lambda (cell)
                                (
                                    let ((pino (
                                                evolveCell cell (getNeighbours x y grid))
                                        ))
                                    (incf x)
                                    pino
                                )
                            )
                            row
                        )
                    ))
                    (incf y)
                    gino
                )
            )
        grid
        )
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
     (0 1 0)
     (1 1 0)
     (1 0 1)
   ))
   (y '(a b c))
 )
 (print (car grid))
 (print (cdr grid))
 (print (getCell 0 -1 grid))
 (print (getNeighbours 1 2 grid))
 (print (evolveGrid grid))
))
