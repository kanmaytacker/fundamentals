
accounts = []

def transfer(source: int, destination: int, amount: int) -> None:
    
    source_account = get_account(source)
    update_account(source_account, -amount)

    destination_account = get_account(destination)
    update_account(destination_account, amount)

def get_account(number: int) -> dict:
    return list(filter(lambda account: account['number'] == number, accounts))[0]

def update_account(account: int, delta: int) -> None:
    account['balance'] += delta

if __name__ == '__main__':
    accounts.append({'number': 1, 'balance': 100})
    accounts.append({'number': 2, 'balance': 200})

    transfer(1, 2, 50)
    print(accounts)