export type Player = 'O' | 'X'

const grid = [['','',''],['','',''],['','','']]

const getCell = (position: {y:number, x:number}): string => {
    return grid[position.y][position.x]
}

const makeAMove = (player: Player, position: {y:number, x:number})=>{
    if(!getCell(position)){
        grid[position.y][position.x] = player
    }
}

const getWinner = () : Player | undefined =>{
    return grid.filter((row)=>row.every(cell => cell && cell === row[0]))[0][0] as Player
}

const pickPlayer = (currentPlayer?: Player) : Player=>{
    if(!currentPlayer) return Math.random()>0.5? 'O': 'X'
    if(currentPlayer === 'O') return 'X'
    else return 'O'
}
const moves =  [['X','X','O'],['O','X','O'],['X','X','X']]
const game = (player?:Player) : Player =>{
    const winner = getWinner()
    if(winner) return winner

    //makeAMove(player | pickPlayer(), )

}