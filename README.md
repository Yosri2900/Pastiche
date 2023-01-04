# Pastiche
Pastiche is a software system for detecting plagiarism. Provide the name of a directory containing the files as input, and it returns a sorted list of pairs based on a measure of similarity. Two files are similar if their score is high\
Note: The files have to be in a ".txt" format\
\
Here are sample outputs:\
\
java Pastiche C:\...\alice\data-1 LinkedWordMap Jaccard
average score is 100.00%
\
100.00%, content-1.txt, content-2.txt
102 ms\
\
\
java Pastiche C:\...\alice\data-2 LinkedWordMap Jaccard
average score is 66.92%

99.98%, content-a.txt, content-g.txt
85.45%, content-a.txt, content-c.txt
85.43%, content-c.txt, content-g.txt
83.06%, content-c.txt, content-f.txt
74.48%, content-b.txt, content-d.txt
73.62%, content-d.txt, content-e.txt
72.78%, content-e.txt, content-f.txt
71.83%, content-a.txt, content-f.txt
71.82%, content-f.txt, content-g.txt
71.76%, content-c.txt, content-e.txt
71.11%, content-a.txt, content-e.txt
71.10%, content-e.txt, content-g.txt
62.01%, content-d.txt, content-f.txt
61.18%, content-c.txt, content-d.txt
57.61%, content-b.txt, content-e.txt
57.14%, content-b.txt, content-f.txt
52.42%, content-a.txt, content-d.txt
52.41%, content-d.txt, content-g.txt
48.04%, content-b.txt, content-c.txt
41.01%, content-a.txt, content-b.txt
41.00%, content-b.txt, content-g.txt
513 ms
\
\

