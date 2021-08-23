import math

def matrix_for_traces(traces, offtime, offdist):
    matrix = []
    for i in range(len(traces)):
        matrix.append([])
        for j in range(len(traces)):
            trace1 = traces[i]
            trace2 = traces[j]
            crossing = False
            if offtime != 0 or offdist != 0:
                for time1, coords1 in trace1:
                    for time2, coords2 in trace2:
                        if math.fabs(time1 - time2) <= offtime and dist(coords1, coords2) <= offdist:
                            crossing = True
                            break
            matrix[i].append(int(crossing))
    return matrix

def dist(coords1, coords2):
    offx = coords1[0] - coords2[0]
    offy = coords1[1] - coords2[1]
    return math.sqrt(offx * offx + offy * offy)