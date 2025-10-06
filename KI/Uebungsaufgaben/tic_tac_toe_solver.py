xes = [0,1,0,
       0,0,1,
       0,0,1]

os  = [0,0,0,
       0,0,0,
       1,1,0]

winning_states = [
        [1,1,1,
         0,0,0,
         0,0,0],
        [0,0,0,
         1,1,1,
         0,0,0],
        [0,0,0,
         0,0,0,
         1,1,1],
        [1,0,0,
         0,1,0,
         0,0,1],
        [0,0,1,
         0,1,0,
         1,0,0],
        [1,0,0,
         1,0,0,
         1,0,0],
        [0,1,0,
         0,1,0,
         0,1,0],
        [0,0,1,
         0,0,1,
         0,0,1]
    ]

chosen_move = [False, 0]

# also works foe os despite the param name
def check_win(xes):
    for list in winning_states:
        grid = [0,0,0,0,0,0,0,0,0]
        for i in range(0,9):
            if list[i] == 1 and xes[i] == 1:
                grid[i] = 1
        if grid in winning_states:
            return True
    return False

# muss nach check_win aufgerufen werden, da die funktion nur prüft ob feld voll ist
def check_draw(xes, os):
    for i in range(0,9):
        if xes[i] + os[i] == 0:
            return False
    return True

def is_game_ended(xes,os):
    return check_win(xes) or check_win(os) or check_draw(xes,os)

def get_grid_char(index,xes,os):
    if xes[index] == 1:
        return "X"
    elif os[index] == 1:
        return "O"
    else:
        return " "

def print_grid(xes,os):
    print(get_grid_char(0,xes,os) + "|" + get_grid_char(1,xes,os) + "|" + get_grid_char(2,xes,os))
    print("-+-+-")
    print(get_grid_char(3,xes,os) + "|" + get_grid_char(4,xes,os) + "|" + get_grid_char(5,xes,os))
    print("-+-+-")
    print(get_grid_char(6,xes,os) + "|" + get_grid_char(7,xes,os) + "|" + get_grid_char(8,xes,os))

def score(xes,os,depth):
    score_val = 0
    if check_win(xes):
        score_val = 10 - depth
    elif check_win(os):
        score_val = depth-10
    else:
        score_val = 0
    return score_val

def get_index_of_maximum(array):
    max_index = 0
    max_val = -999999
    for i in range(0,len(array)):
        if array[i]>max_val:
            max_val = array[i]
            max_index = i
    return max_index

def get_index_of_minimum(array):
    min_index = 0
    min_val = 999999
    for i in range(0,len(array)):
        if array[i]<min_val:
            min_val = array[i]
            min_index = i
    return min_index

def get_available_moves(xes,os):
    free_grid_spaces = []
    for i in range(0,9):
        if xes[i] + os[i] == 0:
            free_grid_spaces.append(i)
    return free_grid_spaces

def minimax(xes,os,x_players_turn,depth):
    if is_game_ended(xes,os):
        return score(xes,os,depth)
    scores = [] # an array of scores
    moves = []  # an array of moves
    
    for i in get_available_moves(xes,os):
        new_xes = xes.copy()
        new_os = os.copy()
        if x_players_turn:
            new_xes[i] = 1
        else:
            new_os[i] = 1
        
        scores.append(minimax(new_xes,new_os,not x_players_turn,depth+1))
        moves.append(i)
    
    global chosen_move
    if x_players_turn:
        # This is the max calculation
        max_score_index = get_index_of_maximum(scores)
        chosen_move = [True,moves[max_score_index]]
        return scores[max_score_index]
    else:
        # This is the min calculation
        min_score_index = get_index_of_minimum(scores)
        chosen_move = [False,moves[min_score_index]]
        return scores[min_score_index]

x_players_turn = False

print_grid(xes,os)
print()

while not check_win(xes) and  not check_win(os) and not check_draw(xes,os):
    minimax(xes,os,x_players_turn,0)
    if x_players_turn:
        print("X on " + str(chosen_move[1]))
        xes[chosen_move[1]] = 1
    else:
        print("O on " + str(chosen_move[1]))
        os[chosen_move[1]] = 1
    x_players_turn = not x_players_turn
    print_grid(xes,os)
    print()

if check_win(xes):
    print("X win")
elif check_win(os):
    print("O win")
elif check_draw(xes, os):
    print("draw")
