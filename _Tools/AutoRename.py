import os
from datetime import datetime

path=[
    ###'',
    '..\\Programmers\\Level3'
]

newExtension='java';

for root, dirs, files in os.walk(path[0]):
    for file in files:
        try:
            datetime.strptime(file.split('_')[0], '%y%m%d')
        except ValueError as err:
            prefix=datetime.today().strftime('%y%m%d_')
            _oldPath = path[0] + '\\' + file
            _newPath = path[0] + '\\' + prefix + file
            os.rename(_oldPath, _newPath)
            print(f'Renamed [{_oldPath}] \n-> [{_newPath}]')
    break

for root, dirs, files in os.walk(path[0]):
    for file in files:
        if (file.rsplit('.')[-1] != newExtension):
            _oldPath = path[0] + '\\' + file
            _newPath = path[0] + '\\' + file[:file.rfind('.')] + '.' + newExtension
            os.rename(_oldPath, _newPath)
            print(f'Renamed [{_oldPath}] \n-> [{_newPath}]')
    break