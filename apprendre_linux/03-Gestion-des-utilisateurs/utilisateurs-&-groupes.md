les commandes de bases pour la gestions des utilisateurs.
(source: https://www.youtube.com/watch?v=zRw0SKaXSfI)

Ajouter un utilisateur
<code>sudo adduser \<nom></code>
Supprimer un utilisateur
<code>sudo userdel \<nom></code>

Ajouter un groupe
<code>sudo addgroup \<nom du groupe></code>
Supprimer un groupe
<code>sudo delgroup \<nom du groupe></code>

#### Les permissions

les dossiers et les fichiers possèdent des permissions afin de gérer les accèes aux fichiers.
Pour afficher les permissions, tapez la commande <code>ls -l</code>.
le <code>-l</code> sert à afficher la liste des dossiers et fichier avec plus de détails (permissions, liens, propriétaire, groupe, taille, date, heure).

un exemple:
<code>drwxr-xr-x 2 root root 4096 Jan 31 15:16 folder</code>
le <code>d</code> signifie que l'élement est un dossier. Si c'est un fichier, ça ne sera pas un <code>d</code>mais un <code>-</code>.Les trois lettres suivantes représentes les permissions de l'utilisateur. du groupe et de tout les utilisateurs du système.


4 = read (r)
2 = write (w)
1 = execute (x)

Les chiffres 
par exemple une permissions 7
<code>sudo chmod 777 \<nom du fichier></code>
<code>sudo chmod 777 \<nom du dossier> -r</code>

le <code>-r</code>signifie que la modification de la permission sera effective de façon récursive (donc aussi dans les fichier et dossier enfant) et ne fonctionne que pour les dossiers.

##ownership ##

sudo chown -r <user> <name of file/dir>
sudo chgrp -R <group name> file <name of file/dir>

