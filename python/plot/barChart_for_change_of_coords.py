import numpy as np
import matplotlib.pyplot as plt
Ls = [          1058595261,           1058577314,            1097855766,            1097858412,          1097852947,            1097871142,          1058595269]       
Ys = [9.999999999621423E-6, 3.999999999848569E-5, 4.4721359548302746E-5, 4.4721359548302746E-5, 1.97230829230557E-4, 3.5440090292778934E-4, 7.07106781185402E-4]
Xs = range(1, len(Ys) + 1)
plt.plot(Xs, Ys, '--o')
plt.xlabel('POI ID')
plt.ylabel('change of euclidean distance measured in lon-lat degrees')
plt.xticks(Xs, Ls)
plt.title('Figure 1 : change of coordinates for POIs from Q4 2011 to Q1 2012')
plt.show()
