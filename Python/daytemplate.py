from sys import argv
from os import getenv, path
from utils import load_input

def solve_a(input_data):
    return '[not yet implemented]'

def solve_b(input_data):
    return '[not yet implemented]'

if __name__ == "__main__":
    if len(argv) > 1:
        input_data = load_input(argv[1])
    else:
        input_directory = getenv("AOC_INPUT_DIRECTORY")
        if input_directory == None:
            raise FileNotFoundError("A filepath must be provided as an argument, or a directory provided in the AOC_INPUT_DIRECTORY argument, for this script to function.")
        input_data = load_input(path.join(input_directory,"Day0.txt"))
    
    print(f"Solution to Part A: {solve_a(input_data)}")
    print(f"Solution to Part B: {solve_b(input_data)}")
