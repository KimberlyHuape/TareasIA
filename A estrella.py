#8-PUZZLE A* estrella
from queue import PriorityQueue

# Estado objetivo del 8-puzzle
goal_state = [[1, 2, 3], [4, 5, 6], [7, 8, 0]]

# Función para generar los movimientos válidos
def generate_moves(board):
    moves = []
    zero_row, zero_col = find_zero(board)
    for dr, dc in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
        new_row, new_col = zero_row + dr, zero_col + dc
        if 0 <= new_row < 3 and 0 <= new_col < 3:
            new_board = [row[:] for row in board]
            new_board[zero_row][zero_col], new_board[new_row][new_col] = new_board[new_row][new_col], new_board[zero_row][zero_col]
            moves.append(new_board)
    return moves

# Función para encontrar la posición del cero en el tablero
def find_zero(board):
    for i in range(3):
        for j in range(3):
            if board[i][j] == 0:
                return i, j

# Función para calcular la distancia de Manhattan entre dos posiciones
def manhattan_distance(row1, col1, row2, col2):
    return abs(row1 - row2) + abs(col1 - col2)

# Función heurística: distancia de Manhattan
def heuristic(board):
    distance = 0
    for i in range(3):
        for j in range(3):
            if board[i][j] != 0:
                value = board[i][j] - 1
                target_row, target_col = value // 3, value % 3
                distance += manhattan_distance(i, j, target_row, target_col)
    return distance

# Función de búsqueda A*
def a_star_search(start_state):
    frontier = PriorityQueue()
    frontier.put((0, start_state))
    came_from = {tuple(map(tuple, start_state)): None}
    cost_so_far = {tuple(map(tuple, start_state)): 0}

    while not frontier.empty():
        _, current_state = frontier.get()

        if current_state == goal_state:
            print("Solución encontrada:")
            print_path(current_state, came_from)
            return

        for next_state in generate_moves(current_state):
            new_cost = cost_so_far[tuple(map(tuple, current_state))] + 1
            if tuple(map(tuple, next_state)) not in cost_so_far or new_cost < cost_so_far[tuple(map(tuple, next_state))]:
                cost_so_far[tuple(map(tuple, next_state))] = new_cost
                priority = new_cost + heuristic(next_state)
                frontier.put((priority, next_state))
                came_from[tuple(map(tuple, next_state))] = current_state

    print("No se encontró una solución")



#IMORIMIR SOLUCIN*
def print_path(current_state, came_from):
    path = []
    while current_state:
        path.append(current_state)
        current_state = came_from.get(tuple(map(tuple, current_state)), None)

    path.reverse()
    for idx, state in enumerate(path):
        print(f"Movimiento {idx + 1}:")
        for row in state:
            print(row)
        print()

    print("¡Solución encontrada en", len(path) - 1, "pasos!")

# Ejemplo de uso
start_state = [[1, 2, 3], [4, 0, 5], [7, 8, 6]]  # Estado inicial

print("Búsqueda A*:")
a_star_search(start_state)