# Gerar um troco de 30 usando as moedas 1, 2, 7, 14, 25

def troco_guloso_sem_repeticao(coins, troco):
    retorno = {
        'valor': 0,
        'moedas': []
    }

    coins.sort()
    coins.reverse()

    for coin in coins:
        if retorno['valor'] + coin < troco:
            retorno['valor'] += coin
            retorno['moedas'].append(coin)

    return retorno


def troco_guloso_com_repeticao(coins, troco):
    retorno = {
        'valor': 0,
        'moedas': []
    }

    coins.sort()
    coins.reverse()

    i = 0

    while retorno['valor'] < 30 and i < len(coins):
        if retorno['valor'] + coins[i] <= troco:
            retorno['valor'] += coins[i]
            retorno['moedas'].append(coins[i])
        else:
            i += 1

    return retorno


if __name__ == '__main__':
    coins = [1, 2, 7, 14, 25]

    troco = troco_guloso_sem_repeticao(coins, 30)

    print('')
    print('Troco sem repetição: ', troco)

    troco = troco_guloso_com_repeticao(coins, 30)

    print('')
    print('Troco com repetição: ', troco)
