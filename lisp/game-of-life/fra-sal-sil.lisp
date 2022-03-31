; Rules
; For a space that is populated:
; Examples
; Each cell with one or no neighbors dies, as if by  solitude.
; Each cell with four or more neighbors dies, as if by overpopulation.
; Each cell with two or three neighbors survives.
; 
; For a space that is empty or unpopulated:
; Each cell with three neighbors becomes populated.

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

)