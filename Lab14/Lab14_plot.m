%Nick Graham Plotting
%CSC 172 Lab 14
figure
title ('Bubble Sort')
hold on;
x = [10 100 500 1000 5000 10000 50000 100000];
y = [0 2 10 27 152 632 16144 64265];
scatter(x,y)

figure
title ('Insertion Sort')
x = [10 100 500 1000 5000 10000 50000 100000];
y = [0 1 7 11 75 192 4321 17303];
scatter(x,y)

figure
title ('Shell Sort')
x = [10 100 500 1000 5000 10000 50000 100000];
y = [0 0 0 3 5 7 30 67];
scatter(x,y)

figure
title ('Array Sort')
x = [10 100 500 1000 5000 10000 50000 100000];
y = [0 1 1 2 5 9 20 38];
scatter(x,y)