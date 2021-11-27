import subprocess
import datetime as dt

git_path = 'C:\\Program Files\\Git\\cmd\\git.exe'
commit_path = 'D:\\Algorithm'
branch_name = 'main'
commit_message = dt.datetime.strftime(dt.datetime.now(), '%y%m%d')
commands = [
    [git_path, 'add', '*'],
    [git_path, 'commit', '-m', commit_message],
    [git_path, 'push', 'origin', branch_name],
]

def run_commands():
    for command in commands:
        print('command : ', end='')
        print(command)
            
        try:
            outputMessage = subprocess.run(
                command,
                cwd=commit_path,
                check=True,
                stdout=subprocess.PIPE).stdout

            print("output : ", end='')
            print(outputMessage)
        except Exception as e:
            print("*ERROR : ", end='')
            print(e)
            
def main():
    run_commands()

if __name__ == "__main__":
	main()
