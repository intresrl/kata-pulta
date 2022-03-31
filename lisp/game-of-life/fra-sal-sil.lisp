; Rules
; For a space that is populated:
; Examples
; Each cell with one or no neighbors dies, as if by  solitude.
; Each cell with four or more neighbors dies, as if by overpopulation.
; Each cell with two or three neighbors survives.
;
; For a space that is empty or unpopulated:
; Each cell with three neighbors becomes populated.



(defun bottles (x)
  (loop for bottles from x downto 1
        do (format t "~a bottle~:p of beer on the wall~@
                      ~:*~a bottle~:p of beer~@
                      Take one down, pass it around~@
                      ~V[No more~:;~:*~a bottle~:p of~] beer on the wall~2%"
                   bottles (1- bottles))))

(bottles 99)
