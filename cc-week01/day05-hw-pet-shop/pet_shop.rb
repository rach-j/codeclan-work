def pet_shop_name(shop_hash)
  return shop_hash[:name]
end

def total_cash(shop_hash)
  return shop_hash[:admin][:total_cash]
end

def add_or_remove_cash(shop_hash, cash)
  shop_hash[:admin][:total_cash] += cash
end

def pets_sold(shop_hash)
  return shop_hash[:admin][:pets_sold]
end

def increase_pets_sold(shop_hash, number_sold)
  shop_hash[:admin][:pets_sold] += number_sold
end

def stock_count(shop_hash)
  return shop_hash[:pets].length()
end

def pets_by_breed(shop_hash, breed)
  breed_array = []
  for pet in shop_hash[:pets]
    if (pet[:breed] == breed)
      breed_array.push(pet[:name])
    end
  end
  return breed_array
end
# Returns array of names of pets with breed given as parameter but test doesn't
# care about names - just need an array of length equal to number of pets of the
# breed in question

def find_pet_by_name(shop_hash, name_of_pet)
  for pet in shop_hash[:pets]
    if (pet[:name] == name_of_pet)
      return pet
    end
  end
  return nil
end

def remove_pet_by_name(shop_hash, name_of_pet)
  for pet in shop_hash[:pets]
    if (pet[:name] == name_of_pet)
      shop_hash[:pets].delete(pet)
    end
  end
end

def add_pet_to_stock(shop_hash, new_pet_hash)
  shop_hash[:pets].push(new_pet_hash)
end

def customer_pet_count(customer)
  return customer[:pets].length
end

def add_pet_to_customer(customer, new_pet)
  customer[:pets].push(new_pet)
end

def customer_can_afford_pet(customer, pet)
  return customer[:cash] >= pet[:price]
end

def sell_pet_to_customer(shop_hash, pet, customer)
  for animal in shop_hash[:pets]
    if (animal == pet && customer_can_afford_pet(customer, pet))
      increase_pets_sold(shop_hash,1)
      # or shop_hash[:admin][:pets_sold] += 1
      add_or_remove_cash(shop_hash, pet[:price])
      # or shop_hash[:admin][:total_cash] += pet[:price]
      customer[:cash] -= pet[:price]
      add_pet_to_customer(customer, pet)
      remove_pet_by_name(shop_hash, pet[:name])
    end
  end
end
