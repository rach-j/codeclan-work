#A

stops = [
  "Croy",
  "Cumbernauld",
  "Falkirk High",
  "Linlithgow",
  "Livingston",
  "Haymarket"
  ]

# 1. Add "Edinburgh Waverley" to the end of the array

stops.push("Edinburgh Waverley")

# 2. Add "Glasgow Queen St" to the start of the array

stops.unshift("Glasgow Queen Street")

# 3.Add "Polmont" at the appropriate point (between "Falkirk High" and
# "Linlithgow")

stops.insert(4, "Polmont")

# 4. Work out the index position of "Linlithgow"

index_of_linlithgow = stops.find_index("Linlithgow")

# 5. Remove "Livingston" from the array using its name

stops.delete("Livingston")

# 6. Delete "Cumbernauld" from the array by index

index_of_cumbernald = stops.find_index("Cumbernauld")
stops.delete_at(index_of_cumbernald)

# 7. How many stops there are in the array?

number_of_stops = stops.length

# 8. How many ways can we return "Falkirk High" from the array?

p stops[2]
p stops.at(2)
p stops.slice(2)
p stops.fetch(2)
p stops[-5]
p stops.at(-5)
p stops.slice(-5)
p stops.fetch(-5)

for stop in stops
  if (stop == "Falkirk High")
    p stop
  end
end

counter = 0
while (stops[counter] != "Falkirk High")
  counter += 1
end
p stops[counter]

stops.each {|stop|
  if (stop == "Falkirk High")
    p stop
  end
  }

# 9. Reverse the positions of the stops in the array

stops.reverse!

# 10. Print out all the stops using a for loop

for stop in stops
  p stop
end

#B

users = {
  "Jonathan" => {
    :twitter => "jonnyt",
    :lottery_numbers => [6, 12, 49, 33, 45, 20],
    :home_town => "Stirling",
    :pets => [
    {
      :name => "fluffy",
      :species => "cat"
    },
    {
      :name => "fido",
      :species => "dog"
    },
    {
      :name => "spike",
      :species => "dog"
    }
  ]
  },
  "Erik" => {
    :twitter => "eriksf",
    :lottery_numbers => [18, 34, 8, 11, 24],
    :home_town => "Linlithgow",
    :pets => [
    {
      :name => "nemo",
      :species => "fish"
    },
    {
      :name => "kevin",
      :species => "fish"
    },
    {
      :name => "spike",
      :species => "dog"
    },
    {
      :name => "rupert",
      :species => "parrot"
    }
  ]
  },
  "Avril" => {
    :twitter => "bridgpally",
    :lottery_numbers => [12, 14, 33, 38, 9, 25],
    :home_town => "Dunbar",
    :pets => [
      {
        :name => "monty",
        :species => "snake"
      }
    ]
  }
}

# 1. Get Jonathan's Twitter handle (i.e. the string "jonnyt")

users["Jonathan"][:twitter]

# 2. Get Erik's hometown

users["Erik"][:home_town]

# 3. Get the array of Erik's lottery numbers

users["Erik"][:lottery_numbers]

# 4. Get the type of Avril's pet Monty

for pet in users["Avril"][:pets]
  if (pet[:name].downcase == "monty")
    avril_pet_monty = pet[:species]
  end
end

# 5. Get the smallest of Erik's lottery numbers

users["Erik"][:lottery_numbers].min()

# 6. Return an array of Avril's lottery numbers that are even

even_lottery_numbers = users["Avril"][:lottery_numbers].delete_if{
  |num| num.odd?}

# 7. Erik is one lottery number short! Add the number 7 to be included in his
# lottery numbers

users["Erik"][:lottery_numbers].push(7)

# 8. Change Erik's hometown to Edinburgh

users["Erik"][:home_town] = "Edinburgh"

# 9. Add a pet dog to Erik called "Fluffy"

users["Erik"][:pets].push({name: "Fluffy", species: "dog"})

#10. Add another person to the users hash

users["Rachel"] = {
    :twitter => "rachelishungry",
    :lottery_numbers => [13, 2, 49, 19, 22, 36],
    :home_town => "London",
    :pets => [
    {
      :name => "Jack",
      :species => "cat"
    },
    {
      :name => "Benji",
      :species => "dog"
    }
  ]
  }

# C

united_kingdom = [
  {
    name: "Scotland",
    population: 5295000,
    capital: "Edinburgh"
  },
  {
    name: "Wales",
    population: 3063000,
    capital: "Swansea"
  },
  {
    name: "England",
    population: 53010000,
    capital: "London"
  }
]

# 1. Change the capital of Wales from "Swansea" to "Cardiff".

for country in united_kingdom
  if (country[:name] == "Wales")
    country[:capital] = "Cardiff"
  end
end

# 2. Create a Hash for Northern Ireland and add it to the united_kingdom array
# (The capital is Belfast, and the population is 1,811,000).

p united_kingdom.push({name: "Northern Ireland",
                     population: 1811000,
                     capital: "Belfast"
                     })

# 3. Use a loop to print the names of all the countries in the UK.

for country in united_kingdom
  p country[:name]
end

# 4. Use a loop to find the total population of the UK.

total_population = 0
for country in united_kingdom
  total_population += country[:population]
end
