#!/usr/bin/env bash

mod_name="kotlin"

root="assets/${mod_name}"
models="${root}/models"
textures="${root}/textures"
blockstates="${root}/blockstates"

mkdir -p ${root}

mkdir ${models}
mkdir ${models}/item
mkdir ${models}/block

mkdir ${textures}
mkdir ${textures}/items
mkdir ${textures}/blocks

mkdir ${blockstates}