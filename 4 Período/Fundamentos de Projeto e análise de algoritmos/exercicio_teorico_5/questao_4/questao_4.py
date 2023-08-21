def div(nums):
    if len(nums) == 1:
        if nums[0] % 2 == 1:
            return nums[0]
        else:
            return 0
    else:
        aux1 = []

        for x in range(int(len(nums) / 2)):
            aux1.append(nums[x])

        aux2 = []

        for x in range(int(len(nums) / 2), len(nums)):
            aux2.append(nums[x])

        div1 = div(aux1)
        div2 = div(aux2)

        return div2 + div1


if __name__ == '__main__':
    test = [8, 9, 4, 6, 3, 4, 2, 1]

    t = div(test)

    print('Resposta: ', t)
