# Le Terminal (CLI)

Le terminal/interface en ligne de commande est une interface texte dans le système d’exploitation. Avec cette interface, vous pouvez organiser les fichiers, lancer des programmes ou exécuter d’autres commandes qui affectent le système d’exploitation, l’ordinateur ou même le réseau.

## les Principales commandes

Connaître les commandes des tout les jours sera un game-changer dans ta maîtrise de Linux.
En voici quelque unes:

### Savoir où tu te trouve dans le system de fichier avec *pwd*

pwd signifie Print Working Directory. Il te reverra le répertoire dans lequel tu te trouve après avoir taper la commande.

```BASH
root@linux:~$ pwd
/root
```

### Check ton login avec *whoami*

```BASH
root@linux:~$ whoami
root
```

### Change de répertoire avec *cd*

cd (pour **C**hange **D**irectory) est une commande pour naviger dans les répertoires.

```Bash
root@linux:~$ cd /etc
```

Pour revenir en arrière

```Bash
root@linux:~$ cd ../ 
```

### Lister les elements d'un répertoire avec *ls*

```Bash
root@linux:~$ ls
```

### Créer/supprimer un fichier avec *touch/rm*

```Bash
root@linux:~$ touch fichier.txt 
```

```Bash
root@linux:~$ rm fichier.txt 
```

### Créer/supprimer un répertoire avec *mkdir/rmdir*

```Bash
root@linux:~$ mkdir <nom du dossier>
```

```Bash
root@linux:~$ rmdir <nom du dossier>
```

### Copy avec *cp*

```Bash
root@linux:~$ cp <nom du dossier>
```

### Déplacer/renommer avec *mv*

```Bash
root@linux:~$ mv <ancien nom> <nouveau nom>
```

```Bash
root@linux:~$ mv <nom du fichier/dossier> <chemin/de/destionation>
```

### Nettoyer avec *clean*

```Bash
root@linux:~$ clean
```

Whoosh! Voilà un terminal tout propre.

### Besoin d'info sur une commande? Utilisez *man*

```Bash
root@linux:~$ man <nom de la commande>
```

Il existe de très nombreuses commandes qu'on ne verra pas ici.
N'oubliez jamais ceci, en développement, Google est votre meilleur ami.
