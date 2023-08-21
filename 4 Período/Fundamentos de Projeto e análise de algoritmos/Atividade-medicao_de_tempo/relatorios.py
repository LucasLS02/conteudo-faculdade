import xlsxwriter


def gerarRelatorio(tempos_execucao, metodo, tam_vetor):
    workbook = xlsxwriter.Workbook('/Users/lucas/Desktop/Faculdade/4 Período/Fundamentos de Projeto e análise de '
                                   'algoritmos/Atividade-medicao_de_tempo/' + metodo + '_' + str(tam_vetor) + '.xlsx')
    worksheet = workbook.add_worksheet(name=metodo)
    worksheet.set_default_row(height=40)
    worksheet.set_column(first_col=0, last_col=2, width=35)

    title = workbook.add_format({'bg_color': 'a9a6a6', 'bold': 1, 'font_size': 12, 'font_name': 'Arial',
                                 'align': 'center', 'valign': 'vcenter', 'border': 1})

    text = workbook.add_format({'font_size': 12, 'align': 'center', 'valign': 'vcenter', 'font_name': 'Calibri',
                                'border': 1})

    worksheet.merge_range(0, 0, 0, 1, metodo, title)

    worksheet.write(1, 0, 'Tentativa', title)
    worksheet.write(1, 1, 'Tempo de execução', title)

    line = 2
    index = 1
    valor_total = 0
    for tempo in tempos_execucao:
        valor_total += tempo
        worksheet.write(line, 0, index, text)
        worksheet.write(line, 1, tempo, text)
        line += 1
        index += 1

    worksheet.write(line + 1, 0, 'Tamanho do vetor', title)
    worksheet.write(line + 1, 1, tam_vetor, text)

    worksheet.write(line + 2, 0, 'Média de tempo', title)
    worksheet.write(line + 2, 1, (valor_total/len(tempos_execucao)), text)

    workbook.close()
