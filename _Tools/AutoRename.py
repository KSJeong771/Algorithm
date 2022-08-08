import os
from datetime import datetime
from pathlib import Path

root_paths = [
    '..\\Programmers',
    '..\\Baekjoon'
]

extensions = ['.java', '.py', '.c', '.cpp', '.cs']
new_extension = '.java'

def has_date_prefix(file_name):
    try:
        datetime.strptime(file_name.split('_')[0], '%y%m%d')
    except ValueError:
        return False
    return True

def create_date_prefix():
    return datetime.today().strftime('%y%m%d_')

def has_correct_extension(file_name):
    for extension in extensions:
        if (Path(file_name).suffix == extension):
            return True
    return False

for root_path in root_paths:
    for parent_path, dirs, files in os.walk(root_path):
        for file in files:
            date_prefix = '' if has_date_prefix(file) else create_date_prefix()
            extension = Path(file).suffix if has_correct_extension(file) else new_extension

            new_file_path = '{0}\\{1}{2}{3}'.format(parent_path, date_prefix, Path(file).stem, extension)
            current_file_path = parent_path + '\\' + file
            
            if (new_file_path != current_file_path):
                os.rename(current_file_path, new_file_path)
                print(f'Renamed [{current_file_path}] \n-> [{new_file_path}]')